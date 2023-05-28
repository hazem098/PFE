export interface Task{
 
    id: any;
   title: string;
   description : string;
   estimation : string;
   startDate : Date ;
   endDate : Date;
   taskPhase : taskPhase;
   isInDelay: boolean;
}
   export enum taskPhase{
    A_FAIRE = "A_FAIRE",
    EN_COURS = "EN_COURS"
   }
  


