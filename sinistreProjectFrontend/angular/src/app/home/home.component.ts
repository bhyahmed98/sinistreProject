import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from '../services/http.service';
import { Sinistre } from '../shared/sinistre';



















export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  typesOfShoes: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers','Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers','Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];
  listSinistre: Array<Sinistre>= new Array<Sinistre>();
  displayedColumns: string[] = ['demo-position', 'demo-name', 'demo-weight', 'demo-symbol'];



  @ViewChild(MatTable) table: MatTable<PeriodicElement>;


  refresh(): void {
    window.location.reload();
}

  removeData() {

    this.table.renderRows();
  }



  


  ngOnInit(): void {
    console.log(this.listSinistre);
    
  }
  ngOnChange():void{}


  startTime = new Date().getTime();

  constructor(private httpService:HttpService,private route:ActivatedRoute,private router:Router,) {
    this.loadSinistres();
    
    
    this.startTime=new Date().getTime();
    
    
    
  }

  
  goToAddPage():void{
    this.router.navigateByUrl('/addsinistre');
  }



  deletSinistre(id:number):void{;

    const i = this.listSinistre.findIndex(e=>e.numeroSinistre==id);
    console.log(i+"this is the id");

    if (i!=-1){
        this.listSinistre.splice(i,1);
    }
    
    console.log(id);
    this.httpService.deleteSinistre(id).subscribe(
      ()=> {console.log(id + 'deleted successfully' )
      this.refresh();
    
    }
    );
    
    

  }





  loadSinistres():void{
    this.httpService.getSinistres()
    .subscribe(result=>{
      this.listSinistre = result; 
      var elapsedTime = new Date().getTime() - this.startTime;

      console.log(elapsedTime);
      console.log(this.listSinistre);
      
    })
  }



  

}
