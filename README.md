# az-func-feedback-report

A @TimerTrigger anotação na função define o uso do schedule mesmo formato de cadeia de caracteres que as expressões CRON

```
  * * * * * <command to execute>
# | | | | |
# | | | | day of the week (0–6) (Sunday to Saturday; 
# | | | month (1–12)             7 is also Sunday on some systems)
# | | day of the month (1–31)
# | hour (0–23)
# minute (0–59)
```