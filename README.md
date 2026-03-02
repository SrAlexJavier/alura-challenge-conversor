# 💱 Conversor de Monedas - Challenge Alura

<p align="center">
  <img src="https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java" alt="Java">
  <img src="https://img.shields.io/badge/Status-Completo-success?style=for-the-badge" alt="Status">
  <img src="https://img.shields.io/badge/License-MIT-blue?style=for-the-badge" alt="License">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Alura-Challenge-blue?style=flat-square&logo=alura" alt="Alura Challenge">
  <img src="https://img.shields.io/badge/API-ExchangeRate--API-green?style=flat-square" alt="API">
</p>

## 📋 Descripción

Aplicación de consola desarrollada en Java que permite realizar conversiones de monedas en tiempo real utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/). Este proyecto fue desarrollado como parte del **Challenge de Alura LATAM**, demostrando el uso de conceptos modernos de Java, consumo de APIs REST, manejo de JSON y buenas prácticas de programación.

##  Características

-  **Conversión en tiempo real**: Obtiene tasas de cambio actualizadas desde ExchangeRate-API
-  **6 pares de monedas predefinidos**:
  - USD ↔ PEN (Dólar ↔ Sol Peruano)
  - USD ↔ EUR (Dólar ↔ Euro)
  - USD ↔ GBP (Dólar ↔ Libra Esterlina)
-  **Interfaz interactiva**: Menú en loop que permite múltiples conversiones
-  **Manejo de errores**: Validación de entradas y gestión de errores de API
-  **Resultados precisos**: Muestra tasas de cambio con 4 decimales
-  **Arquitectura limpia**: Separación de responsabilidades por capas

##  Demostración

```
1) USD =>> PEN
2) PEN =>> USD
3) USD =>> EUR
4) EUR =>> USD
5) USD =>> GBP
6) GBP =>> USD
7) Salir
Elija una opción valida:
**********************************************

> 1

Ingrese la cantidad a convertir: 
> 100

El valor 100.00 [USD] corresponde al valor final de =>>> 370.50 [PEN]
(Tasa de cambio: 1 USD = 3.7050 PEN)
```

##  Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17+ | Lenguaje de programación |
| **HttpClient** | Java 11+ | Cliente HTTP para consumo de API |
| **Gson** | 2.13.2 | Parsing de respuestas JSON |
| **ExchangeRate-API** | v6 | Obtención de tasas de cambio |

### ¿Por qué estas tecnologías?

- **Java 17+**: Utiliza características modernas como Records, HttpClient nativo y var
- **HttpClient**: Cliente HTTP moderno y eficiente incluido en Java 11+
- **Gson**: Biblioteca robusta y ampliamente utilizada para manejo de JSON
- **ExchangeRate-API**: API gratuita, confiable y con buena documentación

##  Estructura del Proyecto

```
alura-challenge-conversor/
│
├── src/
│   └── com/aluracursos/challengeconversor/
│       ├── Principal.java                    # Clase principal con main()
│       │
│       ├── api/
│       │   └── ExchangeRateClient.java      # Cliente HTTP para API externa
│       │
│       ├── service/
│       │   └── CurrencyConverter.java       # Lógica de conversión de monedas
│       │
│       ├── model/
│       │   └── CurrencyPair.java            # Record para par de monedas
│       │
│       ├── menu/
│       │   └── ConsolePrinter.java          # Impresión del menú en consola
│       │
│       └── utils/
│           └── Config.java                   # Configuración (API Key, pares)
│
├── lib/
│   └── Gson/
│       └── gson-2.13.2.jar                  # Dependencia Gson
│
└── README.md
```

###  Descripción de Capas

- **`api/`**: Comunicación con servicios externos (ExchangeRate-API)
- **`service/`**: Lógica de negocio de la aplicación
- **`model/`**: Objetos de dominio (Records)
- **`menu/`**: Interfaz de usuario (consola)
- **`utils/`**: Utilidades y configuración

##  Instalación y Configuración

### Prerrequisitos

-  **Java JDK 17 o superior** instalado
-  **Conexión a Internet** (para consultar la API)
-  **IDE recomendado**: IntelliJ IDEA, Eclipse o VS Code

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/alura-challenge-conversor.git
   cd alura-challenge-conversor
   ```

2. **Verificar la biblioteca Gson**
   
   La biblioteca Gson ya está incluida en `lib/Gson/gson-2.13.2.jar`

3. **Configurar API Key** (Opcional)
   
   El proyecto ya incluye una API Key funcional en `Config.java`. Si deseas usar tu propia key:
   
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/)
   - Obtén tu API Key gratuita
   - Actualiza la constante en `src/com/aluracursos/challengeconversor/utils/Config.java`:
   ```java
   public static final String API_KEY = "TU_API_KEY_AQUI";
   ```

##  Ejecución

### Opción 1: Usando IntelliJ IDEA

1. Abrir el proyecto en IntelliJ IDEA
2. Asegurarse de que Gson esté en el classpath
3. Click derecho en `Principal.java` → **Run 'Principal.main()'**

### Opción 2: Compilar y ejecutar desde terminal

**Windows (PowerShell):**
```powershell
# Crear directorio para compilados
mkdir bin

# Compilar
javac -cp "lib/Gson/gson-2.13.2.jar" -d bin src/com/aluracursos/challengeconversor/**/*.java

# Ejecutar
java -cp "bin;lib/Gson/gson-2.13.2.jar" com.aluracursos.challengeconversor.Principal
```

**Linux/Mac:**
```bash
# Crear directorio para compilados
mkdir bin

# Compilar
javac -cp "lib/Gson/gson-2.13.2.jar" -d bin src/com/aluracursos/challengeconversor/**/*.java

# Ejecutar
java -cp "bin:lib/Gson/gson-2.13.2.jar" com.aluracursos.challengeconversor.Principal
```

##  Uso

1. **Iniciar la aplicación**: Ejecutar el programa siguiendo los pasos anteriores

2. **Seleccionar opción**: Elegir un número del 1 al 6 para el par de monedas deseado

3. **Ingresar cantidad**: Escribir el monto a convertir

4. **Ver resultado**: El programa mostrará:
   - Cantidad original y moneda de origen
   - Cantidad convertida y moneda de destino
   - Tasa de cambio utilizada

5. **Repetir o salir**: 
   - Elegir otra opción para hacer otra conversión
   - Elegir la opción "Salir" para terminar

### Ejemplo de Uso Completo

```
1) USD =>> PEN
2) PEN =>> USD
3) USD =>> EUR
4) EUR =>> USD
5) USD =>> GBP
6) GBP =>> USD
7) Salir
Elija una opción valida:
**********************************************

> 1

Ingrese la cantidad a convertir: 
> 100

El valor 100.00 [USD] corresponde al valor final de =>>> 370.50 [PEN]
(Tasa de cambio: 1 USD = 3.7050 PEN)

1) USD =>> PEN
2) PEN =>> USD
3) USD =>> EUR
4) EUR =>> USD
5) USD =>> GBP
6) GBP =>> USD
7) Salir
Elija una opción valida:
**********************************************

> 7
Saliendo del programa
```

##  Arquitectura y Diseño

### Flujo de Ejecución

```
┌─────────────┐
│  Principal  │  → Punto de entrada
└──────┬──────┘
       │
       ▼
┌──────────────────┐
│ ConsolePrinter   │  → Muestra menú
└──────┬───────────┘
       │
       ▼
┌──────────────────┐
│ Usuario ingresa  │  → Opción y cantidad
│ datos            │
└──────┬───────────┘
       │
       ▼
┌──────────────────────┐
│ CurrencyConverter    │  → Procesa conversión
└──────┬───────────────┘
       │
       ▼
┌──────────────────────┐
│ ExchangeRateClient   │  → Consulta API
└──────┬───────────────┘
       │
       ▼
┌──────────────────────┐
│ ExchangeRate-API     │  → Retorna tasas
└──────┬───────────────┘
       │
       ▼
┌──────────────────────┐
│ Muestra resultado    │  → Output formateado
└──────────────────────┘
```

##  Autor

Desarrollado como parte del **Challenge Alura LATAM**

-  **Programa**: Oracle Next Education (ONE)
-  **Institución**: Alura LATAM


<p align="center">
  Hecho con ❤️ para el Challenge de Alura LATAM
</p>
