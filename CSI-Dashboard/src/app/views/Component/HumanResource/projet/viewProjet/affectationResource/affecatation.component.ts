import { Component, OnInit, Inject } from "@angular/core";
import { FormGroup, FormBuilder, Validators, UntypedFormGroup, UntypedFormControl, FormArray, AbstractControl } from "@angular/forms";
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";
import { Employee, Title } from "app/shared/models/Employee";
import { ProjectStatus, ProjectType, Devise } from "app/shared/models/Projet";
import { ResourceService } from "../../../resource/resource.service";
import { ProjetService } from "../../projet.service";

@Component({
    selector: 'app-ngx-table-popup',
    templateUrl: './affectation.component.html'
  })
  export class AffectationComponent implements OnInit {
    public itemForm: FormGroup;;
    public Form: FormGroup;
    
    ProjectStatus = Object.values(ProjectStatus);
    ProjectType = Object.values(ProjectType);
    devise = Object.values(Devise)
    ressourceId:number;
    states: string[];
    selectedFile: File;
    formRessource:FormGroup;
    submitted=false;
    resources : Employee[]
    responsables : Employee[] = []
   
    formWidth = 200; // declare and initialize formWidth property
    formHeight = 700; // declare and initialize formHeight property
    selectedResources: number[] = [];
  
  
    constructor(
      @Inject(MAT_DIALOG_DATA) public data: any,
      public dialogRef: MatDialogRef<AffectationComponent>,
      private fb: FormBuilder,
      private crudService: ProjetService,  
      private resourceService : ResourceService
    ) {    
      
  
    }
    isFieldEnabled(): boolean {
      return !this.data.isNew; // Enable the field if isNew is true
    }
    
  
  
    buildItemForm(item){
      this.itemForm = this.fb.group({
          
        resourceId:[item.resourceId|| '', Validators.required],
        
        
  
         });
        
  
    }
  
   
    ngOnInit() {
     
      this.getResources()
      this.buildItemForm(this.data.payload)
 
    }
  
    submit() {
      this.dialogRef.close(this.itemForm.value)
    }
    
   
   
   
     getResources(){
      this.resourceService.getItems().subscribe((data :any )=>{
        this.resources = data
       // this.partnerId = this.data.partnerId;
      });
    }
    
    }