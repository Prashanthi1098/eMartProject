import { Item } from './item';

export interface BillDetails{
    id: number,
    billId: number,
    items: Item[]
}