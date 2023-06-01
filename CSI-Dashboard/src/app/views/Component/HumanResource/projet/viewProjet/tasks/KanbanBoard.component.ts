// kanban-board.component.ts
import { Component, ElementRef, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { ActivatedRoute } from '@angular/router';
import { ProjetService } from '../../projet.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { TaskPopupComponent } from './taskPopup/taskPopup.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppLoaderService } from 'app/shared/services/app-loader/app-loader.service';
import { MatTableDataSource } from '@angular/material/table';
import { AppConfirmService } from 'app/shared/services/app-confirm/app-confirm.service';


@Component({
  selector: 'app-kanban-board',
  templateUrl: './kanbanBoard.component.html',
  styleUrls: ['./kanBoard.component.css']
})
export class KanbanBoardComponent implements OnInit {
  id :number
  projet : any
  private tasks: any[]
  public dataSource: MatTableDataSource<any>;
    public displayedColumns: any;
  currentDate: Date=new Date();
  constructor(
    private router : ActivatedRoute,
    private crudService: ProjetService,
    private snack: MatSnackBar,
      private dialog: MatDialog,
      private confirmService: AppConfirmService,
    
      private loader : AppLoaderService,
      private elementRef: ElementRef
   
  ) { this.dataSource = new MatTableDataSource<any>([]); }

  ngOnInit() {
    this.id = this.router.snapshot.params['id'];
    this.getItem()
    this.gettasks()
    this.gettask()
    this.displayedColumns = this.getDisplayedColumns();
  }
  gettask(){
    this.crudService.ProjectTask(this.id).subscribe((data:any) =>{
this.tasks=data
    })}
    gettasks(){
      this.crudService.ProjectTask(this.id).subscribe((data:any) =>{
  this.dataSource=data
      })}
  getItem(){
    this.crudService.getItem(this.id).subscribe((data:any) =>{
this.projet=data
    })
}
getDisplayedColumns() {
  return ['Titre' , 'Description' , 'DateDébut' , 'DateFin','Actions'];
}
isEndDateExpired(row: any): boolean {
  const endDate = new Date(row.endDate);
  return endDate < this.currentDate;
}
deleteItem(row) {
  this.confirmService.confirm({message: `étes vous sure de supprission ?`})
    .subscribe(res => {
      if (res) {
        this.loader.open('Supprission du tache');
        this.crudService.deleteTask(row)
          .subscribe((data:any)=> {
            this.dataSource = data;
            this.loader.close();
            this.snack.open('tache supprimée!', 'OK', { duration: 2000 });
            this.gettasks();
          })
      }
    })
}

 /* tasks: any[] = [
    {
      
      title: 'Tache 1',
      description: 'Crud',
      status: 'A faire',
      assignee: 'John Doe'
    },
    {
      
      title: 'Tache 2',
      description: 'travailler sur tache 2',
      status: 'En cours',
      assignee: 'Jane Smith'
    },
    {
     
      title: 'Tache 3',
      description: 'completer tache 3',
      status: 'Terminé',
      assignee: 'John Doe'
    },
    {
     
      title: 'Tache 4',
      description: 'Finir tache 4',
      status: 'A faire',
      assignee: 'John Doe'
    },
    {
      
      title: 'Tache 5',
      description: 'test',
      status: 'Test',
      assignee: 'Hazem'
    }
  ];*/

 statuses: string[] = ['A_FAIRE', 'EN_COURS','TEST','TERMINE'];
  // TypeScript code


// Store the statuses in local storage



  getTasksByStatus(status: string): Task[] {
    const currentDate = new Date();
    return this.tasks.filter(task => task.taskPhase === status);
  }

  onDragStart(event: DragEvent, task: any): void {
    event.dataTransfer!.setData('text/plain', task.id.toString());
  }

  onDrop(event: CdkDragDrop<Task[], any>, status: string): void {
    const taskId = +event.item.data;
    const taskIndex = this.tasks.findIndex(task => task.id === taskId);
    this.tasks[taskIndex].status = status;
    moveItemInArray(this.tasks, taskIndex, event.currentIndex);
  }
  /*getStatusClass(status: string): string {
    switch (status) {
      case 'A_FAIRE':
        return 'status-todo';
      case 'EN_COURS':
        return 'status-in-progress';
      case 'TERMINE':
        return 'status-done';
       default:
        return 'status-test';
    }
  }*/
  openPopUp(data:  any , isNew?) {
    let title = isNew ? 'Nouvelle tache' : 'Modifier projet';
    this.crudService.getResources(this.id).subscribe((resources: any) => {
    let dialogRef: MatDialogRef<any> = this.dialog.open(TaskPopupComponent, {
      width: '1000px',

      disableClose: true,
      data: { title: title, payload: data , isNew: isNew , resources : resources , projectId : this.id }
    })
    dialogRef.afterClosed()
      .subscribe(res => {
        if(!res) {
          // If user press cancel
          return;
        
         }
        if (isNew) {
          this.loader.open('Ajout en cours');
          this.crudService.addTask(res)
            .subscribe((data :any)=> {
              this.dataSource = data;
              this.loader.close();
              this.snack.open('tache ajouté avec succès!', 'OK', { duration: 2000 });
              this.gettasks()
              this.gettask()
            });
        } else {
          this.loader.open('modification en cours');
          this.crudService.updateTask(data.id,res)
            .subscribe((data:any) => {
              this.dataSource = data ;
              this.loader.close();
              this.snack.open('Task modifiée avec succées !', 'OK', { duration: 2000 });
              this.gettasks();
            })
      }
      });
    });
  }
  isTaskInDelay(task: any) : boolean {
    const currentDate = new Date();
    return task.endDate < currentDate 
  
    }
   
}
