# Automatización ParaBank - Patrón Screenplay

## Descripción del Proyecto

"Se desarrolló una automatización E2E para ParaBank (https://parabank.parasoft.com/) usando el patrón
Screenplay. Se cubrieron 5 flujos principales: registro de usuario,
creación de cuentas, consulta de saldos, transferencias y actualización
de datos. Se usó Serenity BDD con Cucumber para tener pruebas legibles
y reportes profesionales."

## Objetivo

Automatizar pruebas end-to-end que cubren los flujos principales de ParaBank:

- Registro de nuevos usuarios
- Inicio de sesión
- Creación de cuentas de ahorros
- Consulta de saldos y resumen de cuentas
- Transferencias entre cuentas
- Actualización de información de contacto

## Arquitectura Screenplay

El proyecto sigue el patrón Screenplay con la siguiente estructura:

```
src/
├── main/java/co/edu/uda/certificacion/parabank/
│   ├── interactions/       # Interacciones reutilizables con pausas visuales
│   ├── tasks/             # Tareas de negocio de alto nivel
│   ├── questions/         # Validaciones y verificaciones
│   ├── userinterfaces/    # Mapeo de elementos UI (Page Objects)
│   ├── models/            # Modelos de datos
│   └── utils/             # Utilidades
└── test/
    ├── java/co/edu/uda/certificacion/parabank/
    │   ├── runners/           # Ejecutores de pruebas Cucumber
    │   └── stepdefinitions/   # Definiciones de pasos Gherkin
    └── resources/
        └── features/          # Archivos .feature en Gherkin
```

## Herramientas

- Java JDK 17
- Gradle 9.2.1
- Google Chrome

## Pasos

### 1. Clonar o descargar el proyecto

### 2. Compilar el proyecto

```bash
./gradlew clean build -x test
```

### 3. Ejecutar las pruebas

**Ejecutar todas las pruebas:**

```bash
./gradlew clean test
```

**Ejecutar con un tag específico:**

```bash
./gradlew clean test -Dcucumber.filter.tags="@RegistroExitoso"
```

### 4. ver reportes

## Escenarios de Prueba

### @RegistroExitoso

Registra un nuevo usuario con todos sus datos personales

### @CrearCuentaAhorros

Crea una nueva cuenta de ahorros vinculada a una cuenta existente

### @ConsultarSaldoCuenta

Consulta el resumen y saldo de todas las cuentas

### @TransferenciaEntreClientes

Realiza una transferencia de fondos entre cuentas

### @ActualizarInformacionContacto

Actualiza datos de contacto como teléfono y dirección

## Componentes del Patrón Screenplay

### Actors (Actores)

Los actores representan usuarios del sistema. En nuestro caso: "Juan"

### Tasks (Tareas)

Acciones de negocio de alto nivel:

- `NavegarAParaBank` - Abre el navegador en ParaBank
- `RegistrarseEnParaBank` - Completa el formulario de registro
- `IniciarSesion` - Inicia sesión con credenciales
- `AbrirNuevaCuenta` - Crea una nueva cuenta bancaria
- `ConsultarResumenCuentas` - Navega al resumen de cuentas
- `RealizarTransferencia` - Transfiere fondos entre cuentas
- `ActualizarInformacionContacto` - Modifica datos personales

### Interactions (Interacciones)

Interacciones básicas reutilizables con pausas para visualización:

- `IngresarTextoConPausa` - Ingresa texto con delay
- `HacerClicConPausa` - Hace clic con delay
- `Esperar` - Pausa configurable
- `SeleccionarOpcion` - Selecciona de dropdown con delay

### Questions (Preguntas)

Validaciones del estado del sistema:

- `MensajeBienvenida` - Verifica mensaje tras registro
- `AccesoCuenta` - Verifica acceso al dashboard
- `ConfirmacionCuentaCreada` - Valida creación de cuenta
- `CuentasVisibles` - Verifica listado de cuentas
- `ConfirmacionTransferencia` - Valida transferencia exitosa
- `ActualizacionExitosa` - Verifica actualización de datos

### User Interfaces (Interfaces de Usuario)

Mapeo de elementos web (Page Objects):

- `ParaBankHomePage` - Página principal
- `RegisterPage` - Formulario de registro
- `OpenAccountPage` - Creación de cuentas
- `AccountsOverviewPage` - Resumen de cuentas
- `TransferFundsPage` - Transferencias
- `UpdateContactInfoPage` - Actualizar perfil

## Credenciales de Prueba

Para escenarios con login existente:

- **Usuario:** john
- **Contraseña:** demo
