
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {  Validators,  FormGroup, FormBuilder, UntypedFormGroup, UntypedFormControl, FormArray, AbstractControl, ValidationErrors } from '@angular/forms';
import { Partner,CompanyStatus,WorkField,LegalStatus,Provenance ,Country} from 'app/shared/models/Partner';
import { ProjetService } from '../../projet.service';
import { Devise, ProjectStatus, ProjectType } from 'app/shared/models/Projet';
import { ResourceService } from '../../../resource/resource.service';
import { Employee, Title } from 'app/shared/models/Employee';


@Component({
  selector: 'app-ngx-table-popup',
  templateUrl: './Projetpopup.component.html',
 
})
export class ProjetPopupComponent implements OnInit {
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
  Noresponsables : Employee[] = []
 
  formWidth = 200; // declare and initialize formWidth property
  formHeight = 700; // declare and initialize formHeight property
  selectedResources: number[] = [];


  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ProjetPopupComponent>,
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
        projectReference : [item.projectReference|| '', Validators.required],
        name : [item.name || '', Validators.required], 
      
      description: [item.description || '', Validators.required],
      budget : [item.budget || '', Validators.required ,],
      startDate: [item.startDate ||'', Validators.required, ],
      endDate : [item.endDate || '', Validators.required],
      projectType: [item.projectType || '', Validators.required],
      projectStatus : [item.projectStatus|| 'NOT_STARTED', Validators.required],
      resourceIds:[item.resourceIds|| '', Validators.required],
      responsableNum:[item.responsableId||'',Validators.required],
      

       },);
       this.itemForm.get('startDate').valueChanges.subscribe((value) => {
        // If startDate is set, update the endDate control to disable all dates before the selected startDate
        if (value) {
          this.itemForm.get('endDate').enable();
          this.itemForm.get('endDate').setValidators([Validators.required, this.endDateValidator(value)]);
          this.itemForm.get('endDate').updateValueAndValidity();
        }
      });

  }

 
  ngOnInit() {
    this.Form= new UntypedFormGroup({
      
      name : new UntypedFormControl('', [Validators.required]),
      description: new UntypedFormControl('', []),
      budget :  new UntypedFormControl('', []),
      endDate: new UntypedFormControl('', []),
      startDate: new UntypedFormControl('', []),
      projectType: new UntypedFormControl('',[]),
      projectStatus: new UntypedFormControl('',[]),
      resourceIds:  new UntypedFormControl('' , [])
    })
    this.getResources()
    this.buildItemForm(this.data.payload)
this.getChefs()
this.getNoChefs()

    this.formRessource = this.fb.group({
      value : new FormArray([])
     });
     (this.formRessource.get('value') as FormArray).push(this.fb.group({
      firstName: new UntypedFormControl('', []),
    }));
  }

  /*submit() {
    this.dialogRef.close(this.itemForm.value)
  }*/
  errorMessage : String 
  submit() {
    const startDateControl = this.itemForm.get('startDate');
    const endDateControl = this.itemForm.get('endDate');
  
    if (startDateControl.valid && endDateControl.valid) {
      this.dialogRef.close(this.itemForm.value);
    } else {
      if (startDateControl.invalid) {
        this.errorMessage = 'Please select a valid start date.';
      } else if (endDateControl.invalid) {
        this.errorMessage = 'Please select a valid end date.';
      } else {
        this.errorMessage = 'Please fill in all required fields and ensure the date is valid.';
      }
    }
  }
  endDateValidator(startDate: Date) {
    return (endDateControl) => {
      const endDate = new Date(endDateControl.value);
      if (endDate < new Date(startDate)) {
        return { 'min': true };
      }
      return null;
    };
  }
  
   getResources(){
    this.resourceService.getItems().subscribe((data :any )=>{
      this.resources = data
     // this.partnerId = this.data.partnerId;
    });
  }
  getChefs(){
    this.resourceService.getItemResponsable().subscribe((data: any) => {
      this.responsables = data;
     });
    }
    getNoChefs(){
      this.resourceService.getItemNoResponsable().subscribe((data: any) => {
        this.Noresponsables = data;
       });
      }
    dateValidator(control: AbstractControl): { [key: string]: boolean } | null {
      const startDate = control.get('startDate')?.value;
      const endDate = control.get('endDate')?.value;
      if (startDate && endDate && new Date(startDate) > new Date(endDate)) {
        return { 'invalidDate': true };
      }
      return null;
    }
  }
