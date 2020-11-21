import { Comment } from './comment';
export class Report{
    id: number;
    title: string;
    description: string;
    createdBy: string;
    reportDate: string;
    status: string;
    commentList: Comment[];
}