
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {  Validators,  FormGroup, FormBuilder } from '@angular/forms';
import { Partner,CompanyStatus,WorkField,LegalStatus,Provenance ,Country} from 'app/shared/models/Partner';
import { ProjetService } from '../../projet.service';
import { ProjectStatus, ProjectType } from 'app/shared/models/Projet';


@Component({
  selector: 'app-ngx-table-popup',
  templateUrl: './Projetpopup.component.html'
})
export class ProjetPopupComponent implements OnInit {
  public itemForm: FormGroup;;
 
 
  ProjectStatus = Object.values(ProjectStatus);
  ProjectType = Object.values(ProjectType);
 
  states: string[];
  selectedFile: File;

  formWidth = 200; // declare and initialize formWidth property
  formHeight = 700; // declare and initialize formHeight property


  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ProjetPopupComponent>,
    private fb: FormBuilder,
    private crudService: ProjetService,  
  ) {    
    

  }



  buildItemForm(item){
    this.itemForm = this.fb.group({
        projectReference : [item.projectReference|| '', Validators.required],
        name : [item.name || '', Validators.required], 
      parentCompany : [item.parentCompany || '', Validators.required],
      description: [item.description || '', Validators.required],
      budget : [item.budget || '', Validators.required ,],
      startDate: [item.pstartDate ||'', Validators.required, ],
      endDate : [item.endDate || '', Validators.required],
      projectType: [item.projectType || '', Validators.required],
      projectStatus : [item.projectStatus|| '', Validators.required],
     
       });

  }

 
  ngOnInit() {
    this.buildItemForm(this.data.payload)
  }

  submit() {
    this.dialogRef.close(this.itemForm.value)
  }

  

  


}