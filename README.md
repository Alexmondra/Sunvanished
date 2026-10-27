# 🌑 SunVanished=> segundo-proyect

**SunVanished** es un videojuego 2D de terror, exploración y supervivencia, ambientado en un mundo donde el Sol ha desaparecido misteriosamente.

El jugador deberá explorar escenarios oscuros, encontrar recursos, evitar enemigos y descubrir qué ocurrió con el mundo.

El proyecto busca ofrecer una experiencia sencilla, entretenida y atmosférica, utilizando buenas prácticas de programación y patrones de diseño para mantener un código organizado, reutilizable y fácil de ampliar.

---

## 🎮 1. Características principales

- Videojuego completamente en 2D.
- Modo de un jugador.
- Exploración de escenarios.
- Movimiento del personaje.
- Interacción con objetos.
- Enemigos con comportamientos básicos.
- Sistema sencillo de inventario.
- Recolección de recursos.
- Sistema de salud.
- Iluminación y oscuridad.
- Efectos de sonido.
- Menú principal.
- Sistema de pausa.
- Guardado de progreso.

El objetivo es mantener una jugabilidad sencilla sin sacrificar la calidad del código.

---

## 📖 2. Historia

Un día, el Sol desapareció sin ninguna explicación.

El mundo quedó sumergido en una oscuridad permanente. Las ciudades fueron abandonadas y comenzaron a aparecer criaturas desconocidas.

El protagonista despierta en un lugar aparentemente deshabitado y descubre que algo extraño está ocurriendo.

Sin conocer las causas del fenómeno, deberá explorar, sobrevivir y encontrar respuestas.

Durante su recorrido encontrará pistas, objetos y diferentes amenazas.

**Objetivo principal:** descubrir qué ocurrió con el Sol y sobrevivir a la oscuridad.

---

## 🕹️ 3. Mecánicas del juego

### Movimiento

El jugador podrá desplazarse por escenarios 2D.

Funciones:

- Caminar.
- Correr.
- Interactuar.
- Recibir daño.
- Recoger objetos.

La perspectiva inicial propuesta será **2D vista superior (top-down)**.

### Exploración

El jugador podrá recorrer diferentes escenarios:

- Casas abandonadas.
- Calles oscuras.
- Bosques.
- Edificios.
- Zonas desconocidas.

Cada escenario podrá contener objetos, enemigos y pistas.

### Inventario

Sistema sencillo para administrar objetos.

Permitirá:

- Recoger objetos.
- Almacenar recursos.
- Utilizar consumibles.
- Eliminar objetos.

### Sistema de salud

El personaje tendrá una cantidad determinada de vida.

Podrá:

- Recibir daño.
- Recuperar salud.
- Morir.
- Reaparecer desde un punto de control.

### Enemigos

Los enemigos tendrán comportamientos básicos:

- Permanecer inactivos.
- Patrullar.
- Detectar al jugador.
- Perseguirlo.
- Atacarlo.
- Regresar a su posición.

No se implementará inteligencia artificial compleja durante la primera versión.

### Iluminación

La oscuridad será una característica importante del juego.

Se implementarán:

- Ambientes oscuros.
- Linterna.
- Fuentes de iluminación.
- Zonas con visibilidad limitada.

---

## 🏗️ 4. Arquitectura del proyecto

El proyecto utilizará una arquitectura modular y orientada a objetos.

Se buscará separar las responsabilidades de cada componente para facilitar el mantenimiento.

### Principios de desarrollo

- **SOLID:** aplicar sus principios cuando aporten claridad.
- **DRY:** evitar duplicación innecesaria.
- **KISS:** mantener las soluciones simples.
- **YAGNI:** no implementar funcionalidades que todavía no se necesitan.
- **Separación de responsabilidades:** cada clase o componente debe tener una función clara.

La arquitectura debe adaptarse al tamaño del juego, evitando sobreingeniería.

---

## 🧩 5. Patrones de diseño

Se utilizarán patrones de diseño cuando resuelvan necesidades concretas del proyecto.

### 5.1. State — Patrón Estado

Permitirá administrar los diferentes estados del jugador y los enemigos.

**Ejemplo de estados del jugador:**

```text
Player
├── Idle
├── Walk
├── Run
├── Hurt
└── Dead
```

**Ejemplo de estados de enemigos:**

```text
Enemy
├── Idle
├── Patrol
├── Chase
└── Attack
```

Cada estado tendrá un comportamiento específico.

**Beneficio:** evitar múltiples condiciones complejas dentro de una sola clase.

### 5.2. Observer — Patrón Observador

Permitirá comunicar eventos entre diferentes sistemas sin crear dependencias directas.

**Ejemplos:**

- Cuando el jugador recibe daño, se actualiza la interfaz.
- Cuando recoge un objeto, se actualiza el inventario.
- Cuando muere, se muestra la pantalla correspondiente.
- Cuando completa un objetivo, se notifica al sistema de misiones.

**Beneficio:** mantener los componentes desacoplados.

### 5.3. Factory — Patrón Fábrica

Permitirá centralizar la creación de objetos del juego cuando existan diferentes variantes.

**Ejemplos:**

- Crear enemigos.
- Generar objetos.
- Crear consumibles.

**Beneficio:** evitar repetir la lógica de creación de objetos.

No será necesario implementar una fábrica para cada objeto.

### 5.4. Strategy — Patrón Estrategia

Permitirá implementar comportamientos intercambiables cuando sea necesario.

**Ejemplos:**

- Diferentes formas de movimiento de enemigos.
- Diferentes tipos de ataque.
- Comportamientos de persecución.

**Beneficio:** permitir variaciones sin modificar continuamente las clases principales.

### 5.5. Command — Patrón Comando

Podrá utilizarse para representar acciones del jugador.

**Ejemplos:**

- Moverse.
- Interactuar.
- Utilizar objetos.
- Pausar el juego.

**Beneficio:** separar la entrada del usuario de la ejecución de las acciones.

Se implementará únicamente si el sistema de controles requiere esta separación.

---

## 📁 6. Estructura del proyecto

La siguiente estructura es una referencia conceptual y podrá adaptarse al motor seleccionado.

```text
SunVanished/
│
├── assets/
│   ├── sprites/
│   ├── animations/
│   ├── audio/
│   ├── fonts/
│   └── maps/
│
├── scenes/
│   ├── main_menu/
│   ├── player/
│   ├── enemies/
│   ├── levels/
│   └── ui/
│
├── scripts/
│   ├── core/
│   │   ├── game_manager
│   │   └── save_manager
│   │
│   ├── player/
│   │   ├── player_controller
│   │   ├── player_health
│   │   └── player_states/
│   │
│   ├── enemies/
│   │   ├── enemy_controller
│   │   └── enemy_states/
│   │
│   ├── inventory/
│   │   ├── inventory
│   │   └── item
│   │
│   ├── interactions/
│   │   └── interactable
│   │
│   └── ui/
│       ├── hud
│       └── pause_menu
│
├── data/
│   ├── items/
│   └── enemies/
│
└── README.md
```

Esta estructura podrá simplificarse si el proyecto no necesita todos los directorios.

---

## ⚙️ 7. Sistemas principales

### PlayerController

Responsable de controlar el movimiento y las acciones del jugador.

No deberá encargarse directamente del inventario, la interfaz o el comportamiento de enemigos.

### HealthComponent

Responsable de administrar la salud.

Funciones:

- Recibir daño.
- Recuperar salud.
- Detectar la muerte.
- Emitir eventos relacionados con cambios de salud.

Podrá reutilizarse para el jugador y los enemigos.

### Inventory

Responsable de almacenar y administrar los objetos del jugador.

### EnemyController

Responsable de coordinar el comportamiento de los enemigos mediante estados.

### InteractionSystem

Responsable de detectar y ejecutar interacciones con objetos del escenario.

### GameManager

Responsable de coordinar el estado general de la partida.

No deberá convertirse en una clase que controle todos los sistemas del juego.

### SaveManager

Responsable de guardar y recuperar la información necesaria para continuar una partida.

---

## 🎨 8. Diseño visual

El juego tendrá una estética 2D oscura y minimalista.

### Características

- Sprites 2D.
- Animaciones sencillas.
- Escenarios con poca iluminación.
- Efectos de partículas básicos.
- Interfaz minimalista.
- Colores oscuros.
- Iluminación localizada.

Se priorizará el rendimiento y la claridad visual.

---

## 🔊 9. Audio

El sonido ayudará a crear una atmósfera de misterio y tensión.

Se incluirán:

- Música ambiental.
- Pasos del jugador.
- Sonidos de enemigos.
- Interacciones.
- Efectos de daño.
- Sonidos del entorno.

---

## 🚀 10. Primera versión (MVP)

La primera versión será un prototipo 2D completamente jugable.

### Funcionalidades

- [ ] Menú principal.
- [ ] Movimiento del jugador.
- [ ] Animaciones básicas.
- [ ] Colisiones.
- [ ] Un escenario explorable.
- [ ] Interacción con objetos.
- [ ] Sistema de salud.
- [ ] Un tipo de enemigo.
- [ ] IA básica mediante estados.
- [ ] Inventario sencillo.
- [ ] Iluminación básica.
- [ ] Pantalla de muerte.
- [ ] Reinicio de partida.
- [ ] Sistema de pausa.

### Objetivo del MVP

El jugador deberá explorar un escenario oscuro, recoger un objeto importante y llegar a una zona segura mientras evita a un enemigo.

Este prototipo permitirá validar las mecánicas principales antes de ampliar el contenido.

---

## 📋 11. Fases de desarrollo

### Fase 1 — Base del juego

- Configuración del proyecto.
- Escena principal.
- Movimiento del jugador.
- Colisiones.
- Cámara 2D.

### Fase 2 — Jugabilidad

- Interacciones.
- Sistema de salud.
- Enemigos básicos.
- Estados del jugador y enemigos.

### Fase 3 — Sistemas adicionales

- Inventario.
- Objetos.
- Eventos.
- Interfaz.

### Fase 4 — Ambientación

- Iluminación.
- Sonidos.
- Animaciones.
- Diseño del escenario.

### Fase 5 — Finalización del prototipo

- Menú principal.
- Pausa.
- Pantalla de muerte.
- Pruebas.
- Corrección de errores.
- Optimización.

---

## 🧪 12. Calidad del código

El desarrollo deberá cumplir las siguientes recomendaciones:

1. Utilizar nombres claros y descriptivos.
2. Mantener clases y funciones pequeñas.
3. Evitar código duplicado.
4. Separar la lógica del juego de la interfaz.
5. Utilizar señales o eventos para comunicar sistemas.
6. Evitar dependencias circulares.
7. No crear abstracciones innecesarias.
8. Aplicar patrones de diseño únicamente cuando aporten valor.
9. Mantener una estructura consistente.
10. Priorizar código legible y mantenible.

**Importante:** no es obligatorio utilizar todos los patrones de diseño. La simplicidad del juego tendrá prioridad sobre la cantidad de patrones implementados.

---

## 🎯 13. Objetivo del proyecto

Desarrollar un videojuego 2D sencillo de terror y exploración que permita aplicar buenas prácticas de ingeniería de software.

El proyecto servirá para practicar:

- Programación orientada a objetos.
- Arquitectura modular.
- Patrones de diseño.
- Gestión de estados.
- Programación basada en eventos.
- Desarrollo de videojuegos 2D.
- Organización y mantenimiento del código.

La prioridad será construir un juego funcional, entretenido y bien estructurado.

---

## 📌 14. Estado del proyecto

**Nombre:** SunVanished  
**Género:** Terror / Exploración 2D  
**Perspectiva propuesta:** Top-down  
**Modalidad:** Un jugador  
**Estado:** En desarrollo  
**Versión inicial:** 0.1.0  
**Motor:** Por definir  

---

**SunVanished — Cuando el Sol desaparece, comienza la verdadera oscuridad.**
