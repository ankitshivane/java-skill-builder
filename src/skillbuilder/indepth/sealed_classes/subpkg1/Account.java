package skillbuilder.indepth.sealed_classes.subpkg1;

import skillbuilder.indepth.sealed_classes.subpkg1.accounts.DematAccount;
import skillbuilder.indepth.sealed_classes.subpkg2.SavingAccount;

/**
 * Uncomment below line one by one and try
 * Note: when uncommenting any line must go to that child class and try adding either of the any keyword final, non-sealed, or sealed
 */
//sealed public class Account permits SavingAccount {
//sealed public class Account permits DematAccount {
sealed public class Account permits CurrentAccount {
}
