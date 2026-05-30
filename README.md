# 🏡 Sistema de Administración de Condominio Vista Verde
Sistema de escritorio desarrollado en **Java con Java Swing** para la administración de cuotas de mantenimiento del Condominio Vista Verde. Proyecto final del curso de Programación I — Universidad Mariano Gálvez de Guatemala, 2026.

**Facultad de Ingeniería en Sistemas de Información**
Curso: Programación I | Catedrático: César Alejandro Juárez López

---

## 📋 Descripción del Proyecto
El Condominio Vista Verde cuenta con **30 casas** (numeradas del 1 al 30). Este sistema permite al administrador:
- Registrar a los propietarios de cada casa
- Registrar pagos mensuales de cuota de mantenimiento (Q1,500.00 por defecto)
- Consultar el estado de cuenta por casa
- Generar reportes generales de recaudación
- Identificar casas morosas del mes actual
- Configurar el monto de la cuota de mantenimiento

> **Recaudación mensual esperada:** Q45,000.00 (30 casas × Q1,500.00)

---

## 👥 Integrantes del Equipo
| Nombre | Carné | Rol |
|---|---|---|
| Angel Alexander Zelada Donado | 0900-24-19888 | Líder del proyecto |
| José Andres Molina Hinestroza | 0900-25-18276 | Desarrollador principal — Modelo y lógica |
| Jose Carlos Trejo Cartagena | 0900-25-19324 | Desarrollador UI — Pantallas Login e Inicio |
| Samuel Nehemías Chocojay Sandoval | 0900-25-18814 | Desarrollador UI — Pantallas de Registro |
| Luis Pablo Argueta Manzo | 0900-25-3857 | Desarrollador UI — Pantallas Cuenta y Configuración |
| Cristian Geovany Lucho Ramírez | 0900-25-8312 | Documentación |

---

## ⚙️ Requisitos para Ejecutar el Proyecto
- **Java JDK 8** o superior instalado
- **NetBeans IDE 12** o superior (se recomienda la versión con JDK incluido)
- **Git** instalado

---

## 🚀 Cómo Ejecutar
```bash
git clone https://github.com/andresmoln/condominio-vista-verde.git
```

**En NetBeans:**
1. Ir a **File → Open Project**
2. Navegar a la carpeta `condominio-vista-verde`
3. Clic en **Open Project**
4. Clic derecho sobre el proyecto → **Run** (o F6)

### Credenciales de acceso
| Campo | Valor |
|---|---|
| Usuario | `iusr_vistaverde` |
| Contraseña | `R3sidencial2026%` |

---

## 🖥️ Pantallas del Sistema
1. **Login** — Autenticación del administrador
2. **Inicio** — Menú principal con acceso a todos los módulos
3. **Registro de Propietario** — Alta de propietarios por casa
4. **Registro de Pago** — Registro de cuotas mensuales
5. **Configuración de Cuota** — Modificar el monto de mantenimiento
6. **Estado de Cuenta** — Consulta de pagos por casa
7. **Reporte General** — Resumen de las 30 casas en JTable
8. **Casas Morosas** — Lista de casas sin pago en el mes actual

---

## 💾 Persistencia de Datos
El sistema guarda automáticamente todos los datos en un archivo `datos.txt` al cerrar sesión. Al iniciar el programa, los datos se cargan automáticamente. El archivo se genera en la carpeta raíz del proyecto.

---

## 📊 Gestión del Proyecto
- **Tablero Jira:** https://andresmoln02.atlassian.net/jira/software/projects/CVV/boards/34
- **Repositorio GitHub:** https://github.com/andresmoln/condominio-vista-verde

---

## 🗂️ Estructura del Proyecto
```
condominio-vista-verde/
├── src/main/java/com/umg/vistaverde/
│   ├── model/          → Casa, Propietario, Pago, Condominio
│   ├── service/        → CondominioService
│   ├── ui/             → Todas las pantallas Swing
│   └── CondominioVistaVerde.java
├── docs/
│   ├── diagramas/      → Diagrama de clases
│   └── manual/         → Manual de usuario PDF
├── pom.xml
└── README.md
```

