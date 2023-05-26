import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Employee } from "app/shared/models/Employee";
import { EgretCalendarEvent } from "app/shared/models/event.model";
import { Projet } from "app/shared/models/Projet";
import { catchError, Observable } from "rxjs";

@Injectable()
export class ProjetService {
  private apiUrl = 'http://localhost:8084/project';
  private apiUrl2 = 'http://localhost:8084/task';
 
  public events: EgretCalendarEvent[];
  constructor(private http: HttpClient) {}
  getItems(): Observable<Projet[]> {
    const apiUrlWithGET = this.apiUrl + '/getAll';
    return this.http.get<any>(apiUrlWithGET).pipe();
  }
  getTask(): Observable<any[]> {
    const apiUrlWithGET = this.apiUrl2 + '/getAll';
    return this.http.get<any>(apiUrlWithGET).pipe();
  }
  addTask(task:any): Observable<any> {
    const apiUrlWithGET = this.apiUrl2 + '/add';
    return this.http.post<any>(apiUrlWithGET,task).pipe();
  }
  addItem(projet: any): Observable<any> {
    const apiUrlWithAdd = this.apiUrl + '/add'; // Append /add to the apiUrl
    return this.http.post<any>(apiUrlWithAdd, projet).pipe();
  }
  getItem(id: number): Observable<Projet> {
    const url = `${this.apiUrl+ '/getById'}/${id}`;
    return this.http.get<Projet>(url).pipe();
  }
  updateItem(id: number, projet: Projet): Observable<Projet> {
    const url = `${this.apiUrl +'/updateById'}/${id}`;
    return this.http.put<Projet>(url, projet).pipe()
      
    
  }
  deleteItem(id: number): Observable<Projet> {
 
    const url = `${this.apiUrl+'/deleteById'}/${id}`;
    return this.http.delete<Projet>(url).pipe();
  }
  getResources(id: number): Observable<Employee[]> {
    const url = `${this.apiUrl+ '/getResources'}/${id}`;
    return this.http.get<any>(url).pipe();
  }
  addResourceToProject(projectId: number, resourceIds: number[]) {
    const url = `${this.apiUrl}/${projectId}/resources`;
    return this.http.post(url, resourceIds);
  }
  }