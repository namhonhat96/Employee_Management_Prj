import { Report } from './report';
import { COMMENTS } from './mock-comments';

export const REPORTS: Report[] = [
  { id: 1, title: 'Report Title 1', description: 'description 1', createdBy: 'Mr.A', 
    reportDate: '1/1/2020', status: 'Open', commentList: COMMENTS},
  { id: 2, title: 'Report Title 2', description: 'description 2', createdBy: 'Mr.B', 
    reportDate: '1/2/2020', status: 'In Progress', commentList:  COMMENTS},
];