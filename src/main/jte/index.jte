@import dev.franzon.habittracker.dto.HabitoDeHojeDTO
@import java.util.List

@param List<HabitoDeHojeDTO> habitosDeHoje

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.10/dist/full.min.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/htmx.org@2.0.2"></script>
</head>
<body>
<div class="navbar bg-base-100 space-x-4">
    <a class="btn btn-ghost bg-primary" href="http://localhost:8080">Hábitos de hoje</a>
    <a class="btn btn-accent" href="http://localhost:8080/gerenciar-habitos" >Gerenciar hábitos</a>
</div>
<div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 p-6">
    @for(var habitoDeHoje : habitosDeHoje)
        @template.habitoDeHoje(habitoDeHoje = habitoDeHoje)
    @endfor
</div>
</body>
</html>