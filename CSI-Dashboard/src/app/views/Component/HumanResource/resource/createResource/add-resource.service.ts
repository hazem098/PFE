import { contact } from '../../../../../shared/models/contact';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee, EmployeeStatus } from 'app/shared/models/Employee';
import { contract } from 'app/shared/models/contract';
import { Observable, catchError, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddResourceService {

  private apiUrl = 'http://localhost:8084/rh/resource';

  

  constructor(private http: HttpClient) { 

  }

/******* Implement your APIs   Ressource ********/
  getItems(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl).pipe(
      catchError(this.handleError)
    );
  }

  
   // GET an item by id
   getItem(id: number): Observable<Employee> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Employee>(url).pipe(
      catchError(this.handleError)
    );
  }
  // POST a new item
  addItem(resource: any): Observable<any> {
    const url = `${this.apiUrl}/addResource`;
    return this.http.post<any>(url, resource).pipe(
      catchError(this.handleError)
    );
  }
  
   // PUT an existing item
   updateItem(id: number, resource: Employee): Observable<Employee> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.put<Employee>(url, resource).pipe(
      catchError(this.handleError)
    );
  }

  // DELETE an item by id
  deleteItem(id: number): Observable<Employee> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete<Employee>(url).pipe(
      catchError(this.handleError)
    );
  }




  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

}
