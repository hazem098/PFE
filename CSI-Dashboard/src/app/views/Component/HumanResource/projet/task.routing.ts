import { Routes } from "@angular/router";
import { ProjetComponent } from "./add projet/projet.component";


export const ProjetRoutes: Routes = [
    { 
      path:'projet', 
      component: ProjetComponent,
      data: { title: 'list' , breadcrumb: '' } 
    }
]