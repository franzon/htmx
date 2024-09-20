<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SimpleHabits</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>

<body class="bg-slate-100">
    <div class="p-4 bg-blue-900 text-white flex">
        <span class="grow  text-lg font-bold font-mono">
            <a href="/">SimpleHabits</a>
        </span>
        <a href="habitos">
            <i class="fa-solid fa-list-check"></i>
        </a>
    </div>

    <div class="p-4">
        <span class="font-mono">Estes são os hábitos pendentes atualmente...</span>
    </div>

    <div class="p-4 flex flex-col gap-3">
        <div class="bg-gray-300 p-6 rounded-md shadow-sm max-w-lg">
            <div class="flex">
                <span class="grow line-through">Correr</span>
                <input type="checkbox" class="w-6 accent-blue-900" checked />
            </div>
        </div>

        <div class="bg-white p-6 rounded-md shadow-md flex max-w-lg">
            <span class="grow font-bold">Tomar café</span>
            <input type="checkbox" class="w-6 accent-blue-900" />
        </div>

        <div class="bg-red-200 p-6 rounded-md shadow-md flex max-w-lg">
            <span class="grow font-bold">Arrumar a cama</span>
            <input type="checkbox" class="w-6 accent-blue-900" />
        </div>
    </div>
</body>

</html>