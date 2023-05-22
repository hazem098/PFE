import { Routes } from "@angular/router";
import { ProjetComponent } from "./add projet/projet.component";
import { ViewProjetComponent } from "./viewProjet/viewProjet.component";


export const ProjetRoutes: Routes = [
    { 
      path:'projet', 
      component: ProjetComponent,
      data: { title: 'list' , breadcrumb: '' } 
    },
    
      {
        path: ":id",
        component:ViewProjetComponent ,
        pathMatch: "full"
      }
    
]