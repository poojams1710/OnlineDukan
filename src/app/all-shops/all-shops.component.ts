import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GetUserService } from '../get-user.service';
import { ShopProducts } from '../model/ShopProducts';
import { Shops } from '../model/shops';
import { ShopmenuComponent } from '../shopmenu/shopmenu.component';
import{ MessageService} from 'src/app/message.service';
import { ActivatedRoute } from '@angular/router';
import { from } from 'rxjs';


@Component({
  selector: 'app-all-shops',
  templateUrl: './all-shops.component.html',
  styleUrls: ['./all-shops.component.css']
})
export class AllShopsComponent implements OnInit {

  shops : Array<Shops>
  shopweRecieved : Array<Shops>
  product :any

  newShopProduct : any
  message :'hai'

  constructor(private getallshops : GetUserService,private router :Router,
    private messageService : MessageService
    ) { }

  ngOnInit(): void {
    this.getallshops.getShops().subscribe(
         data => this.setIt(data));

        //  this.getservice.setName('hai');
            //  console.log(this.getservice.message);

  }




  setIt(data){
    this.shopweRecieved = data ;
      this.shops  = new Array<Shops>();

    for(const shop of this.shopweRecieved){

      const shopretrived= new Shops();
      shopretrived.shopId= shop.shopId;
      shopretrived.shopname = shop.shopname;
      //populate retrieved image field so that book image can be displayed
      shopretrived.retrievedImage = 'data:image/jpeg;base64,' + shop.picByte;

      shopretrived.picByte = shop.picByte;
      this.shops.push(shopretrived);
    }
  }





  shopping(shopId : number){

    this.getallshops.getshopProduct(shopId).subscribe((data)=>{
         this.newShopProduct = data ;
         this.messageService.sendMessage(this.newShopProduct);
        //  console.log(this.newShopProduct);
         this.router.navigate(['Products']);

    })

  }

  // hello(){
  //   this.messageService.sendMessage("hai from all shopping");
  // }


}
