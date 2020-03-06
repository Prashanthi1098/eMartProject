import { Category } from './category';

export interface SubCategory{
    id: number,
    name: string,
    categoryId: number,
    brief: string,
    gstPercent: number
}