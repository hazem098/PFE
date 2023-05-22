import { ENTER, COMMA } from "@angular/cdk/keycodes";
import { Component, OnInit, ViewChild } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { MatDialog, MatDialogRef } from "@angular/material/dialog";

import { MatPaginator } from "@angular/material/paginator";
import { MatSnackBar } from "@angular/material/snack-bar";

import { MatSort } from "@angular/material/sort";
import { MatTableDataSource } from "@angular/material/table";
import { ActivatedRoute, Router } from "@angular/router";
import { Employee } from "app/shared/models/Employee";
import { Projet } from "app/shared/models/Projet";
import { AppLoaderService } from "app/shared/services/app-loader/app-loader.service";
import { LoaderDialogComponent } from "app/views/app-dialogs/loader-dialog/loader-dialog.component";

import { Title } from "chart.js";
import { Subscription } from "rxjs";
import { ResourceService } from "../../resource/resource.service";
import { ProjetService } from "../projet.service";
import { AffectationComponent } from "./affectationResource/affecatation.component";

@Component({
    selector: 'Viewprojet-crud',
    templateUrl: './viewProjet.component.html'
  })
  
  
  export class ViewProjetComponent implements OnInit {
   
    
    
   id : number ;
    
   
    public projet : any 
    public dataSource: MatTableDataSource<Employee>;
    public displayedColumns: any;
    public getItemSub: Subscription;
    
  
  
    constructor(
      private router : ActivatedRoute,
      private snack: MatSnackBar,
      private dialog: MatDialog,
      private loader : AppLoaderService,
      private crudService: ProjetService,
      private resourceService: ResourceService
     
    ) {this.dataSource = new MatTableDataSource<Employee>([]); }
  
    ngOnInit() {
        this.id = this.router.snapshot.params['id'];
      this.getItem()
      this.displayedColumns = this.getDisplayedColumns();
      this.getRessources()
    }
    getDisplayedColumns() {
        return ['Reference','Titre' , 'Date début' ];
      }
    getItem(){
        this.crudService.getItem(this.id).subscribe((data:any) =>{
    this.projet=data
        })
    }
    getRessources(){
        this.crudService.getResources(this.id).subscribe((data:any) =>{
    this.dataSource=data
        })
    }
    openPopUp(data: any, isNew?) {
        let title = isNew ? 'Nouveau projet' : 'Modifier projet';
        let dialogRef: MatDialogRef<any> = this.dialog.open(AffectationComponent, {
          width: '400px',
          disableClose: true,
          data: { title: title, payload: data, isNew: isNew }
        });
      
        dialogRef.afterClosed().subscribe(res => {
          if (!res) {
            // If user presses cancel
            return;
          }
      
          if (isNew) {
            this.loader.open('ajout en cours');
            this.crudService.addResourceToProject(this.id, res.resourceId).subscribe((data: any) => {
              this.dataSource = data;
              this.loader.close();
              this.snack.open('resource affecté avec succès!', 'OK', { duration: 2000 });
              this.getRessources();
            });
          }
        });
      }
      
    }