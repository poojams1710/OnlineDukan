import { CartItem } from './cart-item';

export class OrderItem {
    imageurl: string;
    itemprice: number;
    quantity: number;
    itemid: number;

    constructor(cartItem: CartItem) {
        this.imageurl = cartItem.imageurl;
        this.quantity = cartItem.quantity;
        this.itemprice = cartItem.itemprice;
        this.itemid = cartItem.id;
    }
}
