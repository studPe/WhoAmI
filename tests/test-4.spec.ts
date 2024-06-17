import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:8080/');
  await page.getByRole('button', { name: 'New Game' }).click();
  await page.locator('#input-vaadin-number-field-14').click();
  await page.locator('#input-vaadin-number-field-14').fill('1234');
  await page.getByLabel('Select a name').click();
  await page.getByRole('option', { name: 'Alice' }).click();
  await page.getByRole('button', { name: 'Close' }).click();
});