import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { MessageService } from '../message.service';
import { ShopProducts } from '../model/ShopProducts';
;

@Component({
  selector: 'app-online-products',
  templateUrl: './online-products.component.html',
  styleUrls: ['./online-products.component.css']
})
export class OnlineProductsComponent implements OnInit {

  public name: Observable<string>;

  newShopProducts : Array<ShopProducts> ;
  message : any;
  subscription : Subscription;


  constructor(private messageService : MessageService) {}


  ngOnInit(): void {{
     this.messageService.getMessage().subscribe((data)=>{
      this.newShopProducts= data;
      console.log(this.newShopProducts);

    })
  }

  }


   }


