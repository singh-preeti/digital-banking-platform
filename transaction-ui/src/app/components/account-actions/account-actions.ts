import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';

@Component({
  selector: 'app-account-actions',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './account-actions.html'
})
export class AccountActionsComponent {
  id!: number;
  amt!: number;
  from!: number;
  to!: number;

  constructor(private service: AccountService) {}

  deposit() {
    this.service.deposit(this.id, this.amt).subscribe(() => alert('Deposited'));
  }

  withdraw() {
    this.service.withdraw(this.id, this.amt).subscribe(() => alert('Withdrawn'));
  }

  transfer() {
    this.service.transfer(this.from, this.to, this.amt)
      .subscribe(res => alert(res));
  }
}
