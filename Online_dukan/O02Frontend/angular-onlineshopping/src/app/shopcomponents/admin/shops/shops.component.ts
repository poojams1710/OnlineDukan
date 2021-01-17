import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GetUserService } from 'src/app/shopservice/get-user.service';
import { Shops } from 'src/app/model/shops';

@Component({
  selector: 'app-shops',
  templateUrl: './shops.component.html',
  styleUrls: ['./shops.component.css']
})
export class ShopsComponent implements OnInit {

  shops :Array<Shops>
  action:String;
  newshop : Shops;


  constructor(private getshopservice : GetUserService,
    private router :Router,
    private activatedRoute :ActivatedRoute) { }

  ngOnInit(): void {
    this.getshopservice.getShops().subscribe((data)=>{
      this.shops = data ;
    })


      this.activatedRoute.queryParams.subscribe((params) =>{
        this.action = params['action']
      })
  }

   addShops(){
    this.newshop = new Shops();
    this.router.navigate(['admin','shops'] ,{queryParams :{action:'add'}})
    }

}



