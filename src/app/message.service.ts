import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { ShopProducts } from './model/ShopProducts';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(){}
  // private subject = new Subject<any>();
  //  newShopProducts : Array<ShopProducts>

  // sendMessage(newShopProducts){
  //   this.subject.next({newShopProducts})
  // }


  // getMessage():Observable<any>{
  //   return this.subject.asObservable();
  // }

  private items = new BehaviorSubject<ShopProducts[]>(null);


  sendMessage(newItems :ShopProducts[]){
    this.items.next(newItems);
  }

  getMessage():Observable<ShopProducts[]>{
    return this.items.asObservable();
  }



}
