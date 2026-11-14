# Entities
- atm.atm Machine
- entities.User
  - username
- atm.Card
  - cardNum
  - pin


# Flow
- user will insert card
- machine will detect card and ask for pin
- user will enter pin
- machine will verify pin with saved records
- If PIN not verifies
  - throw error
  - reject card
- If PIN verified
  - option will be shown to user
    - Check balance
    - Withdraw / Deposit money
    - In case of withdraw validate current balance > withdraw amount request
  - then deposit or withdraw amount
  - eject card and change the machine atm.state to IDLE




# atm.atm machine State
- IDLE
- CARD_ENTERED
- PIN_ENTERED
- USER_INPUT
- WITHDRAW
- DEPOSIT