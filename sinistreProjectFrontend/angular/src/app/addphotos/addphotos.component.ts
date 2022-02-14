import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit, Type } from '@angular/core';
import { HttpService } from '../services/http.service';
import { saveAs } from 'file-saver';
import { Content } from '@angular/compiler/src/render3/r3_ast';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-addphotos',
  templateUrl: './addphotos.component.html',
  styleUrls: ['./addphotos.component.css']
})
export class AddphotosComponent implements OnInit {
  filenames: string[] =[];
  numeroSinistre=1;
  fileStatus = { status: '', requestType: '', percent: 0 };

  constructor(private httpService:HttpService,private router:Router,private route:ActivatedRoute) { }

  onUploadPhotos(event):void{
    let files = event.target.files;
   
    const formData=new FormData();
    for (const file of files){
      formData.append('files',file,file.name);
    }
    this.httpService.upload(formData,this.numeroSinistre).subscribe(
        event => {
          console.log("uploaded");
          console.log(event);
          this.resportProgress(event);
          this.router.navigateByUrl('/');
        },
        (error:HttpErrorResponse) => {
          console.log(error);
        }
    );
    
  }
  
  
  private resportProgress(httpEvent: HttpEvent<string[]> | HttpEvent<Blob>) : void {
    switch(httpEvent.type){
      case HttpEventType.UploadProgress:
        this.uploadStatus(httpEvent.loaded,httpEvent.total,'Uploading');
        break;

      case HttpEventType.DownloadProgress:
        this.uploadStatus(httpEvent.loaded,httpEvent.total,'Uploading');
        break;

      case HttpEventType.ResponseHeader:
        console.log('header returned',httpEvent);
        break;

      case HttpEventType.Response:
        if (httpEvent.body instanceof Array){
          for (const filename of httpEvent.body){
            this.filenames.unshift(filename); 
          }

        }else{
          saveAs(new File([httpEvent.body!],httpEvent.headers.get('File-Name')!,
          {type: `${httpEvent.headers.get('Content-Type')};charset=uft-8`}));

        }
        break;
        default:
          console.log(httpEvent);



    }
  
  }

  private uploadStatus(loaded: number, total: number, requestType: string) {
    
    this.fileStatus.status = 'progress';
    this.fileStatus.requestType = requestType;
    this.fileStatus.percent = Math.round(loaded * 100 / total) ;
  }



  ngOnInit(): void {
    this.route.params.subscribe(param=>{
      this.numeroSinistre=param.idsinistre;
      
      
    })
  }

}
