import { Component, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { MessageService } from 'src/app/shopservice/message.service';
import { ShopProducts } from 'src/app/model/ShopProducts';
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

  products :Array<ShopProducts>;
  productRecived :Array<ShopProducts>;


  constructor(private messageService : MessageService) {}


  ngOnInit(): void {
     this.messageService.getMessage().subscribe(
      data => this.setIt(data));

    }


    setIt(data){
      this.productRecived = data ;
      this.products  = new Array<ShopProducts>();

    for(const product of this.productRecived){

      const productretrived= new ShopProducts();
      productretrived.productId= product.productId;
      productretrived.productname = product.productname;
      //populate retrieved image field so that book image can be displayed
      productretrived.retrievedImage = 'data:image/jpeg;base64,' + product.picByte;

      productretrived.picByte = product.picByte;
      this.products.push(productretrived);
    }
  }

}





