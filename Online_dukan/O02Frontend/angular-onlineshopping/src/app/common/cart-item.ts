import { Item } from './item';
export class CartItem {
    id: number;
    name: string;
    imageurl: string;
    itemprice:number;
    quantity: number;

    constructor(item: Item) {
        this.id = item.itemid;
        this.name = item.itemname;
        this.imageurl = item.imageurl;

        this.itemprice = item.itemprice;
        this.quantity = 1;
    }
}
