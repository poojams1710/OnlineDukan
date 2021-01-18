import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Item } from 'src/app/common/item';
import { ItemService } from 'src/app/services/item.service';
import { CartStatusComponent } from 'src/app/components/cart-status/cart-status.component';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
 // templateUrl: './item-list-grid.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Item[];
  currentCategoryId: number = 4;
  previousCategoryId: number = 4;
  searchMode: boolean = false;


  // new properties for pagination



  constructor(private itemService: ItemService,
    private cartservice:CartService,
              private route: ActivatedRoute) { }

              ngOnInit(){
                this.route.paramMap.subscribe(() => {
                this.listItems();
                });
              }

  listItems(){

    this.searchMode= this.route.snapshot.paramMap.has('keyword');

    if(this.searchMode){
      this.handleSearchItems();
    }
    else{
    this.handleListItems();
    }

  }


  handleSearchItems(){
    const theKeyword: string = this.route.snapshot.paramMap.get('keyword');


    this.itemService.searchItems(theKeyword).subscribe(
      data => {
        this.items = data;
      }
    );

  }

  handleListItems(){

    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id');

    if (hasCategoryId){
      this.currentCategoryId= +this.route.snapshot.paramMap.get('id');
    }

    else{
      this.currentCategoryId=4;
    }

    this.itemService.getItemList(this.currentCategoryId).subscribe(
      data => {
        this.items=data;
      }
    )
  }









  addToCart(tempitem:Item): void{

    console.log("adding to carttemp"+tempitem.itemname+"   "+tempitem.itemprice);

    const theCartItem=new CartItem(tempitem);
    this.cartservice.addToCart(theCartItem);
  }
}


