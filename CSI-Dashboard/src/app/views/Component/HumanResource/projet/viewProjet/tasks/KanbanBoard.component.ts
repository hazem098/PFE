// kanban-board.component.ts
import { Component } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';


@Component({
  selector: 'app-kanban-board',
  templateUrl: './kanbanBoard.component.html',
  styleUrls: ['./kanBoard.component.css']
})
export class KanbanBoardComponent {
  tasks: any[] = [
    {
      
      title: 'Task 1',
      description: 'Complete task 1',
      status: 'To Do',
      assignee: 'John Doe'
    },
    {
      
      title: 'Task 2',
      description: 'Work on task 2',
      status: 'In Progress',
      assignee: 'Jane Smith'
    },
    {
     
      title: 'Task 3',
      description: 'Finish task 3',
      status: 'Done',
      assignee: 'John Doe'
    },
    {
     
      title: 'Task 4',
      description: 'Finish task 3',
      status: 'Testing',
      assignee: 'John Doe'
    }
  ];

  statuses: string[] = ['To Do', 'In Progress','Testing' ,'Done'];

  getTasksByStatus(status: string): Task[] {
    return this.tasks.filter(task => task.status === status);
  }

  /*onDragStart(event: DragEvent, task: Task): void {
    event.dataTransfer!.setData('text/plain', task.id.toString());
  }

  onDrop(event: CdkDragDrop<Task[], any>, status: string): void {
    const taskId = +event.item.data;
    const taskIndex = this.tasks.findIndex(task => task.id === taskId);
    this.tasks[taskIndex].status = status;
    moveItemInArray(this.tasks, taskIndex, event.currentIndex);
  }*/

}
