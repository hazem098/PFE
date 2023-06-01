import { Employee } from "./Employee";

export interface Task{
 
    id: any;
   title: string;
   description : string;
   estimation : string;
   startDate : Date ;
   endDate : Date;
   taskPhase : taskPhase;
   resource: Employee
}
   export enum taskPhase{
    A_FAIRE = "A_FAIRE",
    EN_COURS = "EN_COURS"
   }
  


