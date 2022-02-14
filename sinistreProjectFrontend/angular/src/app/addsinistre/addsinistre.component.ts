import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../services/http.service';
import { Sinistre } from '../shared/sinistre';

@Component({
  selector: 'app-addsinistre',
  templateUrl: './addsinistre.component.html',
  styleUrls: ['./addsinistre.component.css']
})
export class AddsinistreComponent implements OnInit {
  date_accidant='';
  date_creation='';
  status='';
  sinistre=new Sinistre();

  submit():void{
    console.log("submit!");

  }
  goToHomeage():void{
    this.router.navigateByUrl('/');
  }

  addSinistre():void{
    this.sinistre.dateAccident=this.date_accidant;
    this.sinistre.dateCreation=this.date_creation;
    this.sinistre.statut=this.status;

    this.httpService.addSinistre(this.sinistre).subscribe(
      (result)=> {console.log('sinistre added successfully !!');
            let x =result.numeroSinistre;
            this.router.navigateByUrl('/addimage/'+x);

    }
    );
    
    

  }

  constructor(private httpService:HttpService,private route:ActivatedRoute,private router:Router) {
    
   }

  




  ngOnInit(): void {
    
  }
  ngOnchange():void{
   
  }

}
