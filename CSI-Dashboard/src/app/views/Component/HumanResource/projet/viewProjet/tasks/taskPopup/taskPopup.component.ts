import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { taskPhase } from "app/shared/models/Task";
import { ResourceService } from "app/views/Component/HumanResource/resource/resource.service";

@Component({
    selector: 'app-ngx-table-popup',
    templateUrl: './taskPopup.component.html',
   
  })
  export class TaskPopupComponent implements OnInit {
    Noresponsables : any[]
    taskPhase = Object.values(taskPhase);
    constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<TaskPopupComponent>,
    public resourceService : ResourceService,
    private fb: FormBuilder,){

    }
    public itemForm: FormGroup;
    buildItemForm(item){
        this.itemForm = this.fb.group({
           
            title : [item.title || '', Validators.required], 
          
          description: [item.description || '', Validators.required],
         
          startDate: [item.startDate ||'', Validators.required, ],
          endDate : [item.endDate || '', Validators.required],
            estimation : [item.estimation || Validators.required],
          resourceNum:[item.resourceNum|| '', Validators.required],
          taskPhase:[item.taskPhase|| '', Validators.required],
          
    
           },)}
    ngOnInit() {
        this.buildItemForm(this.data.payload)
        this.getNoChefs()
    }
    submit() {
        this.dialogRef.close(this.itemForm.value)
      }
      getNoChefs(){
        this.resourceService.getItemNoResponsable().subscribe((data: any) => {
          this.Noresponsables = data;
         });
        }
  }