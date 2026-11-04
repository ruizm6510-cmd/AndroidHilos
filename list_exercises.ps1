$content = Get-Content "pdf_extracted.txt" -Raw -Encoding UTF8
$lines = Get-Content "pdf_extracted.txt"
for ($i = 0; $i -lt $lines.Count; $i++) {
    if ($lines[$i] -match 'ejercicio|pr[áa]ctica|actividad|lab') {
        Write-Host "Line $($i+1): $($lines[$i])"
        # Print next 5 lines
        for ($j = 1; $j -le 5; $j++) {
            if ($i + $j -lt $lines.Count) {
                Write-Host "   $($lines[$i+$j])"
            }
        }
    }
}
