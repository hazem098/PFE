export interface Task{
 
  id: any;
   title: string;
   description : string;
   estimation : string;
   startDate : string ;
   endDate : string;
   taskPhase : taskPhase
}
   export enum taskPhase{
    A_FAIRE = "A_FAIRE"
   }
  


