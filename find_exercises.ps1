$content = Get-Content "extracted_pdf_text.txt" -Raw -Encoding UTF8
$matches = [regex]::Matches($content, '(?i)(ejercicio|pr[áa]ctica|actividad|laboratorio)\s*\d*')
foreach ($m in $matches | Select-Object -First 50) {
    $start = [Math]::Max(0, $m.Index - 20)
    $length = [Math]::Min($content.Length - $start, 100)
    $sub = $content.Substring($start, $length) -replace "`n", " "
    Write-Host "Match: $sub"
}
