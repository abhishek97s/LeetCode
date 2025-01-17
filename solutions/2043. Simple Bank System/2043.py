class Bank:
  def __init__(self, balance: List[int]):
    self.balance = balance

  def transfer(self, account1: int, account2: int, money: int) -> bool:
    if not self.__isValid(account2):
      return False
    return self.withdraw(account1, money) and self.deposit(account2, money)

  def deposit(self, account: int, money: int) -> bool:
    if not self.__isValid(account):
      return False
    self.balance[account - 1] += money
    return True

  def withdraw(self, account: int, money: int) -> bool:
    if not self.__isValid(account):
      return False
    if self.balance[account - 1] < money:
      return False
    self.balance[account - 1] -= money
    return True

  def __isValid(self, account: int) -> bool:
    return 1 <= account <= len(self.balance)
