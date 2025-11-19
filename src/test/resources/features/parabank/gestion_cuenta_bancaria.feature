@ParaBank
Feature: Complete bank account management in ParaBank
  As a ParaBank customer
  I want to register create accounts and perform banking operations
  So I can manage my finances securely

  @RegistroExitoso @Escenario1
  Scenario: A - Successful new user registration
    Given Juan navigates to ParaBank platform
    When Juan registers with the following information
    Then Juan should see the welcome message
    And Juan should have access to his account

  @CrearCuentaAhorros @Escenario2
  Scenario: B - Savings account creation
    When Juan requests to create a new savings account
    And Juan selects the source account for initial funds
    Then Juan should see the account creation confirmation
    And Juan should view the new account number

  @ConsultarSaldoCuenta @Escenario3
  Scenario: C - Balance inquiry in existing account
    When Juan checks his accounts summary
    Then Juan should view the list of all his accounts
    And Juan should see the available balance of each account

  @TransferenciaEntreClientes @Escenario4
  Scenario: D - Funds transfer between accounts
    When Juan makes a transfer of 100 dollars to another account
    Then Juan should see the successful transfer message
    And Juan should see the updated balance in his account

  @ActualizarInformacionContacto @Escenario5
  Scenario: E - Customer contact information update
    When Juan updates his contact information
    Then Juan should see the successful update message
    And Juan should view the updated information in his profile