foreach ($cmd in @('python', 'python3', 'py', 'conda', 'dotnet')) {
    $p = Get-Command $cmd -ErrorAction SilentlyContinue
    if ($p) { Write-Host "Found: $cmd at $($p.Source)" } else { Write-Host "Not found: $cmd" }
}
