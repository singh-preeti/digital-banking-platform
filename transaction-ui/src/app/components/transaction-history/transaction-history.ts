import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-transaction-history',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './transaction-history.html'
})
export class TransactionHistoryComponent {
  id!: number;
  transactions: any[] = [];

  constructor(private service: AccountService) {}

  load() {
    this.service.transactions(this.id)
      .subscribe(res => this.transactions = res);
  }
}
