package io.pivotal.microservices.accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;

public class AccountsControllerTests extends AbstractAccountControllerTests {

	protected static final Account theAccount = new Account(ACCOUNT_1,
			ACCOUNT_1_NAME);

	protected static class TestAccountRepository implements AccountRepository {

		@Override
		public Account findByNumber(String accountNumber) {
			if (accountNumber.equals(ACCOUNT_1))
				return theAccount;
			else
				return null;
		}

		@Override
		public List<Account> findByOwnerContainingIgnoreCase(String partialName) {
			List<Account> accounts = new ArrayList<Account>();

			if (ACCOUNT_1_NAME.toLowerCase().indexOf(partialName.toLowerCase()) != -1)
				accounts.add(theAccount);

			return accounts;
		}

		@Override
		public int countAccounts() {
			return 1;
		}

		@Override
		public <S extends Account> S save(S s) {
			return null;
		}

		@Override
		public <S extends Account> Iterable<S> saveAll(Iterable<S> iterable) {
			return null;
		}

		@Override
		public Optional<Account> findById(Long aLong) {
			return Optional.empty();
		}

		@Override
		public boolean existsById(Long aLong) {
			return false;
		}

		@Override
		public Iterable<Account> findAll() {
			return null;
		}

		@Override
		public Iterable<Account> findAllById(Iterable<Long> iterable) {
			return null;
		}

		@Override
		public long count() {
			return 0;
		}

		@Override
		public void deleteById(Long aLong) {

		}

		@Override
		public void delete(Account account) {

		}

		@Override
		public void deleteAll(Iterable<? extends Account> iterable) {

		}

		@Override
		public void deleteAll() {

		}
	}

	protected TestAccountRepository testRepo = new TestAccountRepository();

	@Before
	public void setup() {
		accountController = new AccountsController(testRepo);
	}
}
