import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
  await page.goto('http://localhost:8080/');
  await page.locator('#input-vaadin-number-field-14').click();
  await page.locator('#input-vaadin-number-field-14').fill('1234');
  await page.getByLabel('Select a name').click();
  await page.getByRole('option', { name: 'Bob' }).locator('div').click();
  await page.getByRole('button', { name: 'Start Game!' }).click();
  await page.getByRole('button', { name: 'Close' }).click();
  await page.getByLabel('Who you think you are').click();
  await page.getByLabel('Who you think you are').fill('way');
  await page.getByRole('button', { name: 'Enter Guess' }).click();
  await page.getByLabel('Who you think you are').click();
  await page.getByLabel('Who you think you are').fill('Meryl Can\'t-Streep-Online.');
  await page.getByRole('button', { name: 'Enter Guess' }).click();
  await page.getByRole('button', { name: 'Close' }).click();
  await page.getByRole('button', { name: 'New Game' }).click();
  await page.locator('#input-vaadin-number-field-14').click();
  await page.locator('#input-vaadin-number-field-14').fill('1234');
  await page.getByLabel('Select a name').click();
  await page.getByRole('option', { name: 'Alice' }).locator('div').click();
  await page.getByRole('button', { name: 'Start Game!' }).click();
  await page.getByRole('button', { name: 'Close' }).click();
});