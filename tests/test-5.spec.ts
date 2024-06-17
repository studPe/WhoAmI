import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:8080/');
  await page.getByLabel('Who you think you are').click();
  await page.getByLabel('Who you think you are').fill('1234');
  await page.getByRole('button', { name: 'Enter Guess' }).click();
  await page.getByRole('button', { name: 'Enter Guess' }).click();
  await page.getByRole('button', { name: 'Enter Guess' }).click();
});