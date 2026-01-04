import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AccountCreateComponent } from './components/account-create/account-create';
import { AccountActionsComponent } from './components/account-actions/account-actions';
import { TransactionHistoryComponent } from './components/transaction-history/transaction-history';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AccountCreateComponent, AccountActionsComponent, TransactionHistoryComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('transaction-ui');
}
