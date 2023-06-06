export interface Projet {
id ?: number ;
projectReference ?: string ;
name?: string ;
description?: number ;
budget?: string ;
startDate?: Date
endDate?: Date ;
type?: string
projectStatus?: ProjectStatus
projectType?: ProjectType
}

export enum ProjectStatus{
    NOT_STARTED="NOT_STARTED" ,
    IN_PROGRESS= "IN_PROGRESS",
    ON_HOLD="ON_HOLD" ,
    COMPLETED="COMPLETED" ,
    
}
export enum ProjectType{
    INTERN="INTERN" ,
    EXTERN="EXTERN"
}
export enum Devise{
    DINAR="DT" ,
    EURO="EUR",
    DOLLAR="DLR"
}