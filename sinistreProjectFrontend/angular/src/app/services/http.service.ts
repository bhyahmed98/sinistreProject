import { HttpClient, HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProcessHTTPMsgService } from '../process-httpmsg.service';

import { catchError } from 'rxjs/operators';
import { Sinistre } from '../shared/sinistre';




@Injectable({
  providedIn: 'root'
})
export class HttpService {

 

baseUrl:String="http://localhost:8080/";

constructor(private http: HttpClient,private processHTTPMsgService:ProcessHTTPMsgService) { }

getSinistres():Observable<Array<Sinistre>>{
  return this.http.get<Array<Sinistre>>(this.baseUrl+'sinistre/getall')
  .pipe(catchError(this.processHTTPMsgService.handleError));
}



deleteSinistre(id:number):Observable<void>{
  let x=this.baseUrl+'sinistre/delete/'+id;
  console.log(x);
  return this.http.delete<void>(x)
  .pipe(catchError(this.processHTTPMsgService.handleError));
}

addSinistre(sinistre:Sinistre):Observable<Sinistre>{
  return this.http.post<Sinistre>(this.baseUrl+'sinistre/add',sinistre,{
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  })
  .pipe(catchError(this.processHTTPMsgService.handleError));
}



upload(formData:FormData,idSinistre:number):Observable<HttpEvent<string[]>>{
  return this.http.post<string[]>(this.baseUrl+'photo/upload/'+idSinistre,formData,{
    reportProgress:true,
    observe:'events'

  });
}

download(filename:string):Observable<HttpEvent<Blob>>{
  return this.http.get(this.baseUrl+'photo/download/'+filename,{
    reportProgress:true,
    observe:'events',
    responseType:'blob'
  });
}




}



