
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {  Validators,  FormGroup, FormBuilder, UntypedFormGroup, UntypedFormControl, FormArray, AbstractControl, ValidationErrors } from '@angular/forms';
import { Partner,CompanyStatus,WorkField,LegalStatus,Provenance ,Country} from 'app/shared/models/Partner';
import { ProjetService } from '../../projet.service';
import { Devise, Fnction, ProjectStatus, ProjectType, Projet } from 'app/shared/models/Projet';
import { ResourceService } from '../../../resource/resource.service';
import { Employee, Title } from 'app/shared/models/Employee';
import { MatTableDataSource } from '@angular/material/table';
import { SelectionModel } from '@angular/cdk/collections';
import { PeriodicElement } from 'assets/examples/material/pagination-table/pagination-table.component';
import { MatCheckboxChange } from '@angular/material/checkbox';


@Component({
  selector: 'app-ngx-table-popup',
  templateUrl: './Projetpopup.component.html',
  styleUrls:['./ProjetPopup.component.scss']
  
 
})
export class ProjetPopupComponent implements OnInit {
  public itemForm: FormGroup;;
  public Form: FormGroup;
  isLoading = true;
  ProjectStatus = Object.values(ProjectStatus);
  ProjectType = Object.values(ProjectType);
  fonction=Object.values(Fnction)
  devise = Object.values(Devise)
  ressourceId:number;
  states: string[];
  selectedFile: File;
  formRessource:FormGroup;
  submitted=false;
  resources : Employee[] 
  responsables : Employee[] = []
  Noresponsables : Employee[] = []
  public dataSource: MatTableDataSource<Employee>;
  public displayedColumns: any;
  selection = new SelectionModel<Employee>(true, []);
  selectedResourceIds: number[] = [];

  formWidth = 200; // declare and initialize formWidth property
  formHeight = 1000; // declare and initialize formHeight property
  selectedResources: number[] = [];
  selectedRowIds: number[] = [];
  form: FormGroup;
  responsableClients: FormArray;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
    public dialogRef: MatDialogRef<ProjetPopupComponent>,
    private fb: FormBuilder,
    private crudService: ProjetService,  
    private resourceService : ResourceService
  ) {    
    
    this.dataSource = new MatTableDataSource<Employee>([]);
  }
  isFieldEnabled(): boolean {
    return !this.data.isNew; // Enable the field if isNew is true
  }
  
  getDisplayedColumns() {
    return ['select', 'Nom' , 'Prénom' , 'Poste' ];
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
      resourceIds:[this.selectedRowIds.values|| '', Validators.required],
      responsableNum:[item.responsableId||'',Validators.required],
      realStartDate:[item.realStartDate||'',Validators.required],
      realEndDate:[item.realEndDate||'',Validators.required],
      lieuDuProjet:[item.lieuDuProjet],
      workingHourNumber:[item.workingHourNumber],
      
      
       },);
       this.itemForm.get('startDate').valueChanges.subscribe((value) => {
        // If startDate is set, update the endDate control to disable all dates before the selected startDate
        if (value) {
          this.itemForm.get('endDate').enable();
          this.itemForm.get('endDate').setValidators([Validators.required, this.endDateValidator(value)]);
          this.itemForm.get('endDate').updateValueAndValidity();
        }
      });
 this.form=this.fb.group({
  responsableClients:this.fb.array([this.createResponsableClient()])
 });
 this.responsableClients = this.form.get('responsableClients') as FormArray;
  }

  getRessources(){
    this.isLoading = true;
    this.resourceService.getItems().subscribe((data:any) =>{
this.dataSource.data=data;
this.isLoading = false;
    })
}
  ngOnInit() {
    this.getRessources()
    this.displayedColumns=this.getDisplayedColumns()
    
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
  createResponsableClient(): FormGroup {
    return this.fb.group({
      nom: ['', Validators.required],
      prénom:['',Validators.required],
      description:['',Validators.required],
      adressMail:['',Validators.required],
      phoneNumber: ['',Validators.required]
    })}
      addFormItem(): void {
        const formItem = this.createResponsableClient();
        this.responsableClients.push(formItem);
      }
      removeFormItem(index: number): void {
        if (index === 0 && this.responsableClients.length === 1) {
          return; // Skip removal
        }
        this.responsableClients.removeAt(index);
      }
  /*submit() {
    this.dialogRef.close(this.itemForm.value)
  }*/
  errorMessage : String 
  submit() {
    if (this.responsableClients.controls.some((control, index) => control.pristine && index !== 0)) {
      return;
    }
    const startDateControl = this.itemForm.get('startDate');
    const endDateControl = this.itemForm.get('endDate');
  
    if (startDateControl.valid && endDateControl.valid) {
      console.log(this.selectedRowIds);
      this.dialogRef.close(this.itemForm.value);
    } else {
      if (startDateControl.invalid) {
        this.errorMessage = 'selectionner une date valide.';
      } else if (endDateControl.invalid) {
        this.errorMessage = 'selectionner une date valide.';
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
    isAllSelected() {
      const numSelected = this.selection.selected.length;
      const numRows = this.dataSource.data.length;
      return numSelected === numRows;
    }
  
    /** Selects all rows if they are not all selected; otherwise clear selection. */
  
    /** The label for the checkbox on the passed row */
    toggleSelection(event: MatCheckboxChange, row: Employee) {
    
      this.selection.toggle(row);
      this.updateSelectedRowIds();
      this.updateResourceIds()
        }
    
    toggleSelectionAll(event: MatCheckboxChange) {
     
      this.isAllSelected() ? this.selection.clear() : this.dataSource.data.forEach(row => this.selection.select(row));
      this.updateSelectedRowIds();
    }
    updateSelectedRowIds() {
      this.selectedRowIds = this.selection.selected.map(row => row.id);
    }
    updateResourceIds() {
      this.itemForm.get('resourceIds').setValue(this.selectedRowIds); // Update the resourceIds form control value
    }
  }
