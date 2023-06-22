import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
    selector: 'app-ngx-table-popup',
    templateUrl: './Phase.component.html',
    
    
   
  })
  export class PhaseComponent implements OnInit {
    public itemForm: FormGroup;
    constructor(
        @Inject(MAT_DIALOG_DATA) public data: any,
        public dialogRef: MatDialogRef<PhaseComponent>,
        private fb: FormBuilder,
       
      ) {    
        
        
      }
    ngOnInit(): void {
        this.buildItemForm(this.data.payload)
    }
    buildItemForm(item){
   
        this.itemForm = this.fb.group({
            name : [item.name || '', Validators.required], 
            projectNum: this.data.payload
             });
        }
    submit() {
   
          this.dialogRef.close(this.itemForm.value);
            console.log(this.data.payload)
        }
   
  }