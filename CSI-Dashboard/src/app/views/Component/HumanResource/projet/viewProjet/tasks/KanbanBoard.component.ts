// kanban-board.component.ts
import { Component, OnInit } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { ActivatedRoute } from '@angular/router';
import { ProjetService } from '../../projet.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { TaskPopupComponent } from './taskPopup/taskPopup.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AppLoaderService } from 'app/shared/services/app-loader/app-loader.service';


@Component({
  selector: 'app-kanban-board',
  templateUrl: './kanbanBoard.component.html',
  styleUrls: ['./kanBoard.component.css']
})
export class KanbanBoardComponent implements OnInit {
  id :number
  projet : any
  private tasks: any[]
  constructor(
    private router : ActivatedRoute,
    private crudService: ProjetService,
    private snack: MatSnackBar,
      private dialog: MatDialog,
      private loader : AppLoaderService,
    
   
  ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params['id'];
    this.getItem()
    this.gettask()
    
  }
  gettask(){
    this.crudService.getTask().subscribe((data:any) =>{
this.tasks=data
    })}
  getItem(){
    this.crudService.getItem(this.id).subscribe((data:any) =>{
this.projet=data
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

  getTasksByStatus(status: string): Task[] {
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
  getStatusClass(status: string): string {
    switch (status) {
      case 'A faire':
        return 'status-todo';
      case 'En cours':
        return 'status-in-progress';
      case 'Terminé':
        return 'status-done';
      default:
        return '';
    }
  }
  openPopUp(data:  any , isNew?) {
    let title = isNew ? 'Nouveau projet' : 'Modifier projet';
    let dialogRef: MatDialogRef<any> = this.dialog.open(TaskPopupComponent, {
      width: '1000px',
      disableClose: true,
      data: { title: title, payload: data , isNew: isNew }
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
              this.tasks = data;
              this.loader.close();
              this.snack.open('tache ajouté avec succès!', 'OK', { duration: 2000 });
              this.gettask()
            })
        } 
      })
  }

}
